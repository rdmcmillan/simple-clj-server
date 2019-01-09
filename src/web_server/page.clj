(ns web-server.page
  (:require
   [hiccup.core :refer :all]
   [hiccup.page :refer :all]))


(def doc-head
  [:head
   [:meta {:charset "utf-8"}]
   [:title "Page | Title"]
   [:link {:rel  "shortcut icon"
           :href "images/icons/favicon.ico"}]
   [:link {:rel  "icon"
           :type "image/ico"
           :href "images/icons/favicon.ico"}]
   [:link {:rel  "stylesheet"
           :type "text/css"
           :href "styles/base_style.css"}]])

(def banner
  [:div.banner [:h1 "Sample Landing Page"]
   [:div.menu   [:ul [:li "<a href= \"/another_page\" target=\"_self\">Link To Another Page</a>"]]]])

(def content
  [:div.content
   [:p "This is where the page's main content goes."]
   [:p (str "You can even evaluate clojure functions like this: 2+2=" (+ 2 2))]])


(def footer
  [:div.footer
   [:p "Page footer content. Copyright, etc."]])

(defn landing-page
  "This is a Hiccup html template"
  [_]
  (html5
   doc-head
   [:body
    banner
    content
    footer]))

(defn another-page
  [_]
  (html5
   doc-head
   [:div.banner [:h1 "Another Web Page"]
    [:div.menu   [:ul [:li "<a href= \"/landing_page\" target=\"_self\">Back To Landing Page</a>"]]]]
   [:div.content
    [:p "This is where the page's main content goes."]]
   footer))
