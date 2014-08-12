(ns immutant-messaging-benchmark.core
  (:require [immutant.messaging :as msg]
            [immutant.jobs :as jobs]
            [schmetrics.meter :as meter]))

(defn pub-sub-with-connection
  [topic num-iterations]
  (msg/with-connection {}
    (dotimes [n num-iterations]
      (let [msg (.createBytesMessage (immutant.messaging.core/session))]
        (.writeBytes msg (.getBytes (apply str (repeat 1024 "f"))))
        (msg/publish topic msg :persistent false :encoding :text)
        (meter/mark :pub-with-connection 1)))
    (println (meter/read :pub-with-connection))))

(defn init []
  (let [topic "/topic/pubsub-with-connection"
        num-iterations 50000]
    (msg/start topic)
    (jobs/schedule :pub-sub-with-connection
                   #(pub-sub-with-connection topic num-iterations)
                   :in 5000 ;; let immutant warm up
                   :every 20000
                   :repeat 5)))

