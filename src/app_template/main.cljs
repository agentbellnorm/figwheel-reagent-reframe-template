(ns app-template.main
  (:require [re-frame.core :as re-frame]
            [app-template.event-handlers]
            [app-template.subscriptions]
            [reagent.core :refer [render]]
            [app-template.view.app :refer [app-component]]))

(enable-console-print!)

(defn main!
  []
  (println "main")
  (re-frame/dispatch-sync [:initialize])
  (render [app-component] (js/document.getElementById "app")))


(defn on-js-reload
  []
  (println "reload")
  (render [app-component] (js/document.getElementById "app")))

(main!)

