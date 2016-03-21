(ns web-server.core
  (require
   [org.httpkit.server :refer :all]
   [compojure.route    :refer [files not-found]]
   [compojure.handler  :refer [site]]
   [compojure.core     :refer [defroutes GET POST]]
   [compojure.route    :as route]
   [webserver.page     :refer :all])
  (:gen-class))

(defonce server (atom nil))

(defroutes app-routes
  (GET "/" [] render-page)
  (route/not-found "<p>Page not found.</p>"))

(defn start-server
  [port]
  (reset! server (run-server (site #'app-routes) {:port port})))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (start-server 8080))

