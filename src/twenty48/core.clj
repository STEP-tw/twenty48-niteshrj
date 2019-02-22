(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial filter (comp not zero?)))

(def add-consecutive-equal-numbers
  (comp
   reverse
   (partial map (comp (partial apply +) (partial take-last 2)))
   (partial mapcat (partial partition-all 2))
   reverse
   (partial partition-by identity)))

(def append-zeros (comp (partial take-last 4) flatten (partial cons '(0 0 0 0))))

(def move (comp append-zeros add-consecutive-equal-numbers remove-zeros))

;----------------------------------------------------------------------------------------------

(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move ))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)
