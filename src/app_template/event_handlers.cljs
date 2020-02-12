(ns app-template.event-handlers
  (:require [re-frame.core :as re-frame]
            [app-template.core :refer [get-initial-state]]))

(re-frame/reg-event-db
  :initialize
  (fn [_ _]
    (get-initial-state)))

(re-frame/reg-event-db
  :search-value-changed
  (fn [db [_ value]]
    (assoc db :search-value value)))
