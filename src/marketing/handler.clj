(ns marketing.handler
  (:gen-class)
  (:require [clojure.java.shell :refer [sh]]
            [compojure.core :refer :all]
            [compojure.route :as route :refer [files]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.util.response :refer [file-response]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn file [path]
  (:out (sh "cat" path)))

(defroutes app-routes
  (GET "/" []
       (:out (sh "bash" "bash_on_highway/app/index.bash")))
  (GET "/loader.js" []
       (file-response "loader.js" {:root "./"}))
  (GET  "/jquery-3.2.1.min.js" []
        (file-response "jquery-3.2.1.min.js" {:root "./"}))
  (GET "/:script" [script]
       (:out (sh "bash" (str "bash_on_highway/app/" script ".bash"))))     
  (GET "/pages/style.css" []
       (file "pages/style.css")) 
  (files "/" {:root "./"})
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main []
  (run-jetty app {:port 80}))
