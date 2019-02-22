(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial filter (comp not zero?)))

(def transpose (partial apply mapv vector))

(def add-consecutive-equal-numbers
  (comp
   reverse
   (partial map (comp (partial apply +) (partial take-last 2)))
   (partial mapcat (partial partition-all 2))
   reverse
   (partial partition-by identity)))

(def append-zeros (comp (partial take-last 4) flatten (partial cons (repeat 4 0))))

(def move (comp append-zeros add-consecutive-equal-numbers remove-zeros))

(def move-grid-right "Moves an entire grid to the right" (partial map move ))

(def move-grid-left "Moves an entire grid to the left" (comp (partial map reverse) (partial map move) (partial map reverse)))

(def move-grid-down "Moves an entire grid down" (comp (partial transpose) (partial map move) (partial transpose)))

(def move-grid-up "Moves an entire grid up" (comp (partial transpose) (partial move-grid-left) (partial transpose)))
