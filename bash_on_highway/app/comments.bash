#!/usr/bin/env bash
source $(dirname $0)/base.bash

head;
cat $PAGES_ROOT/comments.html
cat $STATIC_ROOT/comments.txt
cat $PAGES_ROOT/commentsb.html
end;