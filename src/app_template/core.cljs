(ns app-template.core)

(defn get-initial-state []
  {:text         "Hello world!"
   :search-value ""
   :persons      ["Morgan"
                  "Tomas"
                  "Daniel"
                  "Anthony"
                  "Josefin"
                  "Annsofi"
                  "Simon"
                  "Superman"]})

(defn get-search-value
  [db _]
  (get db :search-value))

(defn get-filtered-persons
  [db _]
  (let [query (clojure.string/lower-case (:search-value db))
        all-persons (:persons db)]
    (filter (fn [value]
              (clojure.string/starts-with? (clojure.string/lower-case value) query))
            all-persons)))
