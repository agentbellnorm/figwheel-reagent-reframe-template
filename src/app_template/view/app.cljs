(ns app-template.view.app
  (:require [re-frame.core :as re-frame]))

(defn js-event->value
  [event]
  (-> event
      (.-target)
      (.-value)))

(defn search-input []
  (let [search-value (deref (re-frame/subscribe [:search-value]))]
    [:input {:placeholder "Sök"
             :style       {:outline       "1px solid orange"
                           :margin-bottom "1rem"}
             :on-change   (fn [e] (re-frame/dispatch [:search-value-changed (js-event->value e)]))
             :value       search-value}]))

(defn search-results []
  (let [results (deref (re-frame/subscribe [:filtered-persons]))]
    [:<>                                                    ; React.Fragment
     (map (fn [value]
            [:div {:key   value
                   :style {:font-size "10px"}}
             value])
          results)]))

(defn app-component
  "The main component."
  []
  (let [app-state (deref (re-frame.core/subscribe [:app-state]))]
    (println app-state)                                     ; for debug
    [:div
     [:h1 "Find persons"]
     [search-input]
     [search-results]]))

