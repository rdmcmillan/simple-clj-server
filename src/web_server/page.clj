(ns webserver.page
  (require
   [hiccup.core        :refer :all]
   [hiccup.page        :refer :all]))

(defn render-page
  [_]
  (html5 {:lang "en"}
         [:head [:title "PN Admin | Login"]
                [:link {:rel  "shortcut icon"
                        :href "images/icons/facicon.ico"}]
                [:link {:rel  "icon"
                        :type "image/ico"
                        :href "images/icons/facicon.ico"}]]
         [:body [:h1 "This is the Web Page"]
                [:ul {:class "index"} [:li "Page1"]
                                      [:li "Page2"]
                                      [:li "Page3"]]]))
