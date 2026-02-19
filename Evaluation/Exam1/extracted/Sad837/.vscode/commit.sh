#!/usr/bin/env zsh
# Periodic Git commit script (zsh)
# Sleeps 30 seconds, stages all changes, commits with an incrementing message,
# and pushes when the internal counter becomes a multiple of 10 (preserves original behavior).

count=1
while true; do
    sleep 30

    git add .
    git commit -m "Periodic Commit $count"

    (( count++ ))

    if (( count % 10 == 0 )); then
        git push
    fi
done
