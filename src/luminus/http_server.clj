(ns luminus.http-server
  (:require 
   [clojure.tools.logging :as log]
   [ring.adapter.undertow :refer [run-undertow]]))

(defn start [{:keys [handler port] :as opts}]
  (try
    (let [server (run-undertow handler (dissoc opts :handler))]
      (log/info "server started on port" port)
      server)
    (catch Throwable t
      (log/error t (str "server failed to start on port: " port)))))

(defn stop [server]
  (.stop server)
  (log/info "HTTP server stopped"))
