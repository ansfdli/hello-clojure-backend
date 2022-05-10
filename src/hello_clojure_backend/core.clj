(ns hello-clojure-backend.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.reload :refer [wrap-reload]]))

#_{:clj-kondo/ignore [:unused-binding]}
(defroutes handler
  (GET "/id" [] "halo masyarakat")
  (GET "/en" [] "hello citizen")
  (GET "/user/:name" [name] (str "halo " name)))

(defn start-server []
  (println "Starting server...")
  (run-jetty (wrap-reload (var handler)) {:port 4000}))

(comment
  (start-server))
