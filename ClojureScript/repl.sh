#!/bin/bash

set -e

if [ ! -d out ]
then
    echo "Building shrimp.core..."
    clojure -m cljs.main -t none -c shrimp.core
fi

clj -m cljs.main -co '{:analyze-path ["src"]}' -re ambly -r

