
# CLJS: Up and Running

## New project

```
lein new mies clock
```

## Building

```
lein cljsbuild auto
```

## Advanced build

In project.clj:

```
{:id "prod"
 :source-paths ["src"]
 :compiler {:output-to "hello_world_prod.js" :optimizations :advanced}}
```

Copy index.html to index_prod.html, include only

```
<script src="hello_world_prod.js" type="text/javascript"></script>
```

Then:

```
lein cljsbuild auto
```

## moment.js

```
mkdir resources
curl -o resources/moment.min.js http://momentjs.com/downloads/moment.min.js
```

In index.html:

```
<h1 id="clock"></h1>
<script src="resources/moment.min.js"></script>
```

In core.cljs:

```
(ns clock.core)

(defn start-clock []
  (let [header (js/document.getElementById "clock")
        get-formatted-time #(.format (js/moment) "h:mm:ss a")
        set-formatted-time #(set! (.-innerHTML header) (get-formatted-time))]
    (set-formatted-time)
    (js/setInterval set-formatted-time 1000)))
```

Use `js/moment` because the library is built to expose a `moment`
object in the global scope.

In the console:

```
hello_world.core.start_clock()
```

## Now let's try advanced compilation...

???

## Exports

```
(defn ^:export start-clock []
  ...)
```

## Try something different...

```
(fn [] (.. (js/moment) (endOf "day") fromNow))
```

## Externs

In resources/moment-externs.js

```
var moment = function () {};
moment.prototype.format = function (fstring) {};
moment.prototype.endOf = function (fstring) {};
moment.prototype.fromNow = function () {};
```

In project.clj:

```
:externs ["resources/moment-externs.js"]
```
