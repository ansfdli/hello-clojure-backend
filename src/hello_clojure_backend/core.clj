(ns hello-clojure-backend.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn handler [request]
  {:status 200 :body "hey guys, test BE clojure"})

(defn start-server []
  (println "Starting server...")
  (run-jetty (wrap-reload (var handler)) {:port 4000}))

(comment
  (start-server))
