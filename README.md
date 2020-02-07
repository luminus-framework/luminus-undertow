# luminus-undertow

Undertow HTTP adapter for Luminus

### HTTP handler

```clojure
(ns myapp.core
  (:require
   [luminus.http-server :as http]))

(defn http-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (:remote-addr request)})

(http/start
 {:handler http-handler
  :port 3000})
```

## License

Copyright © 2016 Dmitri Sotnikov

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
