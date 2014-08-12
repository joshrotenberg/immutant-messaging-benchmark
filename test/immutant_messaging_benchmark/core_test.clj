(ns immutant-messaging-benchmark.core-test
  (:require [clojure.test :refer :all]
            [immutant-messaging-benchmark.core :refer :all]
            [immutant.messaging :as msg]
            [schmetrics.meter :as meter]))

;; (deftest pub-sub-test
;;   (testing "standard publish subscribe with a topic"
;;     (pub-sub num-iterations)))

;; (deftest pub-sub-with-connection-test
;;   (testing "standard publish subscribe with a topic using with-connection"
;;     (pub-sub-with-connection num-iterations)))
