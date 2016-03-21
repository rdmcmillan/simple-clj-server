(ns web-server.page
  (require
   [hiccup.core        :refer :all]
   [hiccup.page        :refer :all]))

(defn render-page
  "This is a Hiccup html template"
  [_]
  (html5 {:lang "en"}
         [:head [:title "Page | Title"]
                [:link {:rel  "shortcut icon"
                        :href "images/icons/favicon.ico"}]
                [:link {:rel  "icon"
                        :type "image/ico"
                        :href "images/icons/favicon.ico"}]]
         [:body [:h1 "This is a web page."]
                [:ul {:class "list"} [:li "item1"]
                                     [:li "item2"]
                                     [:li "item3"]]]))
