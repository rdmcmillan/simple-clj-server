(ns web-server.core
  (require
   [org.httpkit.server :refer :all]
   [compojure.route    :refer [files not-found]]
   [compojure.handler  :refer [site]]
   [compojure.core     :refer [defroutes GET POST]]
   [compojure.route    :as route]
   [web-server.page    :refer :all])
  (:gen-class))

(defonce server (atom nil))

(defroutes app-routes
  (GET "/" [] render-page)
  (route/resources "/")
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
  "Starts up a simple server. Takes an optional port number. If not provided,
defaults to 8080."
  [& args]
  (start-server (if (first args)
                  (first args)
                  8080)))
