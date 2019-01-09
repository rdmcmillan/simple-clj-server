(ns web-server.styles
  (:require
   [garden.core :refer :all]))

(def accent-clr "#033E66")

(def bkgrnd-clr "#F2F2F2")

(def style-reset
 ;; From Eric Meyer http://meyerweb.com/eric/tools/css/reset
  [[:html :body :div :span :applet :object :iframe :h1 :h2 :h3 :h4 :h5 :h6 :p :blockquote :prea :abbr :acronym :address :big :cite :code :del :dfn :em :img :ins :kbd :q :s :samp :small :strike :strong :sub :sup :tt :var :b :u :i :center :dl :dt :dd :ol :ul :li :fieldset :form :label :legend :table :caption :tbody :tfoot :thead :tr :th :td :article :aside :canvas :details :embed :figure :figcaption :footer :header :hgroup :menu :nav :output :ruby :section :summary :time :mark :audio :video
     {:margin  0
      :padding 0
      :outline 0
      :font-size "100%"
      :font "inherit"
      :vertical-align "baseline"
      :display "block"
      :margin-bottom "1px"}]
   [:article :aside :details :figcaption :figure
    :footer :header :hgroup :menu :nav :section
    {:display "block"}]
   [:body
    {:line-height 1}]
   [:ol :ul
    {:list-style "none"}]
   [:blockquote :q
    {:quotes "none"}]
   [:blockquote:before :blockquote:after
    :q:before :q:after
    {:content "none"}]
   [:table
    {:border-collapse "collapse"
     :border-spacing 0}]])

(def body
  [[:html {:height "100%"}]
   [:body {:font-size   "16px"
           :font-family "Georgia serif"
           :background   bkgrnd-clr
           :height   "100%"}]])

(def banner
  [:div.banner {:background accent-clr
                :color      "#FFF"
                :height     "100px"
                :width      "100%"}])

(def menu
  [:.menu
   [:ul {:list-style-type "disc"
         :margin-left "25px" }]
   [:li {:display "list-item"}]
   [:a:link {:color "white"
             :text-decoration "none"
             :font "10px 'Open Sans', Sans-Serif"}]
   [:a:hover {:color bkgrnd-clr
              :text-decoration "underline"}]
   [:a:visited {:color "white"}]])

(def content
  [:div.content
   {:height "calc(100% - 75px)"}
   [:p {:text-align "justify"}]])

(def footer
  [:div.footer
   {:position "fixed"
    :bottom "0px"
    :width "100%"
    :height "50px"
    :background accent-clr
    :color      "#FFF"}])

(defn create-base-styles
  []
  (css {:pretty-print? false
        :output-to "resources/public/styles/base_style.css"}
       style-reset
       body
       banner
       menu
       content
       footer))
