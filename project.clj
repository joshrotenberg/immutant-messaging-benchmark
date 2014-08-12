(defproject immutant-messaging-benchmark "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :immutant { :init immutant-messaging-benchmark.core/init }
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [schmetrics "0.2.1" :exclusions 
                  [com.fasterxml.jackson.core/jackson-core]]])                 

