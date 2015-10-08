(ns project-euler.core-test
  (:require [clojure.test :refer :all]
            [project-euler.problem-001 :refer [problem-001]]
            [project-euler.problem-002 :refer [problem-002]]
            [project-euler.problem-003 :refer [problem-003]]
            [project-euler.problem-004 :refer [problem-004]]
            [project-euler.problem-005 :refer [problem-005]]
            [project-euler.problem-006 :refer [problem-006]]
            [project-euler.problem-007 :refer [problem-007]]
            [project-euler.problem-008 :refer [problem-008]]
            [project-euler.problem-009 :refer [problem-009]]
            [project-euler.problem-010 :refer [problem-010]]
            [project-euler.problem-011 :refer [problem-011]]
            [project-euler.problem-012 :refer [problem-012]]
            [project-euler.problem-013 :refer [problem-013]]
            [project-euler.problem-014 :refer [problem-014]]
            [project-euler.problem-015 :refer [problem-015]]
            [project-euler.problem-016 :refer [problem-016]]
            [project-euler.problem-017 :refer [problem-017]]
            [project-euler.problem-018 :refer [problem-018]]
            [project-euler.problem-019 :refer [problem-019]]
            [project-euler.problem-020 :refer [problem-020]]
            [project-euler.problem-021 :refer [problem-021]]
            [project-euler.problem-022 :refer [problem-022]]
            [project-euler.problem-023 :refer [problem-023]]
            [project-euler.problem-024 :refer [problem-024]]
            [project-euler.problem-025 :refer [problem-025]]
            [project-euler.problem-041 :refer [problem-041]]
            [project-euler.problem-067 :refer [problem-067]]))


(deftest all-solutions
  (testing "All solutions"
    (is (= (problem-001) 233168))
    (is (= (problem-002) 4613732))
    (is (= (problem-003) 6857))
    (is (= (problem-004) 906609))
    (is (= (problem-005) 232792560))
    (is (= (problem-006) 25164150))
    (is (= (problem-007) 104743))
    (is (= (problem-008) 23514624000))
    (is (= (problem-009) 31875000))
    (is (= (problem-010) 142913828922))
    (is (= (problem-011) 70600674))
    (is (= (problem-012) 76576500))
    (is (= (problem-013) "5537376230"))
    (is (= (problem-014) 837799))
    (is (= (problem-015) 137846528820))
    (is (= (problem-016) 1366))
    (is (= (problem-017) 21124))
    (is (= (problem-018) 1074))
    (is (= (problem-019) 171))
    (is (= (problem-020) 648))
    (is (= (problem-021) 31626))
    (is (= (problem-022) 871198282))
    (is (= (problem-023) 4179871))
    (is (= (problem-024) "2783915460"))
    (is (= (problem-025) 4782))
    (is (= (problem-041) 7652413))
    (is (= (problem-067) 7273))))
