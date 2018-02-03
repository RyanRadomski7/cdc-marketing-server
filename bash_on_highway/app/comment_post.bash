#!/usr/bin/env bash
source $(dirname $0)/base.bash
export content_length=$(printenv CONTENT-LENGTH)
read -n $content_length body
export FILE=${STATIC_ROOT}/comments.txt


echo "HTTP/1.1 200 Ok"
echo "Content-type: application/json"
echo ""
echo ""
echo "$body" >> $FILE
echo $FILE
echo $body

