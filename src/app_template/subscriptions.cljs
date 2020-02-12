(ns app-template.subscriptions
  (:require [re-frame.core :as re-frame]
            [app-template.core :as core]))

(re-frame/reg-sub
  :app-state
  (fn [db _]
    db))

(re-frame/reg-sub :search-value core/get-search-value)

(re-frame/reg-sub :filtered-persons core/get-filtered-persons)
