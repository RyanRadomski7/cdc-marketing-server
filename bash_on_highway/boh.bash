#! /bin/bash

export PAGES_ROOT=/var/www/marketing/pages
export BOH_ROOT=/var/www/marketing/bash_on_highway

head() {
    http_headers;
    cat $PAGES_ROOT/includes/head.html
}

end() {
    cat $PAGES_ROOT/includes/end.html
    echo
}

http_headers() {
    echo "HTTP/1.1 200 Ok"
    echo "Content-Type: text/html"
    echo "Server: eHTTP"
    echo "X-Powered-By: Bash On Highway"
    echo ""
    echo ""
}
