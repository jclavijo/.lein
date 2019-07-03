{:user
 {; if you are not fortunate enough to have an SSD in your PC,
  ; you will save time using a ramdisk for compiling classes.
  ; in this case, you will make a symlink from the 'target' directory
  ; to the ramdisk.
  ; Yet paths outside the project root cannot be accessed by `lein clean`,
  ; except if we 'deprotect' them like show:
  :clean-targets ^{:protect false} [:target-path]

  ; it is possible to configure any options for a tool in this profile
  ; without importing the corresponding plugin, which will be done only
  ; in projects that use it (in `project.clj`).
  ; for example, codox is a documentation tool, we set its overall options
  ; here but don't import the plugin.
  :codox {:defaults {:doc/format :markdown}
          :writer codox.writer.html/write-docs
          ; source links
          :src-dir-uri "http://github.com/obarbeau/XXX/blob/master/"
          :src-linenum-anchor-prefix "L"}


 ; :global-vars { *print-length* 30 }

  ; shared options for compilation
;  :javac-options ["-target" "8" "-source" "1.7" "-Xlint:-options"]

  ; for debugging an external REPL with eclipse or IntelliJ
  ;:jvm-opts [(str "-agentlib:jdwp=transport=dt_socket,server=y,"
   ;          "suspend=n,address=5005")]

  ; common options for the JVM
;  :jvm-opts ["-XX:+AggressiveOpts" "-XX:+UseCompressedOops"
 ;            "-XX:+OptimizeStringConcat"
  ;           "-XX:+UseFastAccessorMethods" "-server"
   ;          ]

  ; in this `user` profile, use plugins with the less dependencies
  ; as possible
  :plugins [; executing Clojure scripts (in two words)
            [lein-exec                        "0.3.6"]
            ; Add leiningen dependencies quickly
          ;  [lein-plz                         "0.3.0"]
            ; Pretty-print a representation of the project map
            [lein-pprint                      "1.2.0"] ; no dependencies
            ; trying out new libraries without creating a project
            [lein-try                         "0.4.3"]
            ; cider-repl
            ;[cider/cider-nrepl "0.15.0-SNAPSHOT"];slows down lein if active here
            [lein-cljsbuild "1.1.7"]
            ;;;[lein-midje    "3.2.1"]
            ;;;[lein-midje-doc "0.0.24"]
            ;colors
            ;;;;;;;;;;;;;;;;[venantius/ultra "0.5.2"]
            ;;;;[lein-shell "0.5.0"];in repl
            ;;[lein-ancient "0.6.15"]
            [com.billpiel/sayid "0.0.17"]
            [cider/cider-nrepl "0.21.1"]
            [refactor-nrepl "2.4.0"]
            ] ; no dependencies

  ; avoid polluting root directory with an unnecessary pom
  :pom-location "target/"

  :dependencies [[proto-repl "0.3.1"]
                 [nrepl "0.7.0-SNAPSHOT"];for sayid
                 [io.aviso/pretty "0.1.33"]
                 [org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.namespace "0.2.5"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/tools.trace "0.7.9"]
                 ;; [zcaudate/lucid.mind "1.4.7"]
                 ;; [zcaudate/lucid.publish "1.4.7"]
                 ;; [zcaudate/lucid.unit "1.4.7"]
                 ;; ;[zcaudate/lucid.package "1.4.7"]
                 ;; [zcaudate/lucid.core.debug "1.4.7"]
                 ;[zcaudate/lucid.core.inject "1.4.7"]
                 ;; [zcaudate/lucid.core.namespace "1.4.7"]
                 ;[hara/test "3.0.2"]
                 [spieden/spyscope "0.1.7"]
                 [pjstadig/humane-test-output "0.8.2"]
                 [hara/lib.aether "3.0.5"]
                 ]
  :injections [(require 'spyscope.core)
               (require 'hara.lib.aether)
               ;(require '[lucid.core.inject :as inject])
               ;; (inject/in [lucid.core.inject :refer [inject [in inject-in]]]
               ;;            [clojure.pprint pprint]
               ;;            [clojure.java.shell sh]
               ;;            [clojure.repl doc source dir]
                          ;[hara/test :refer [[run-namespace test-namespace]]]
                          ;[hara/lib.aether pull resolve-versions]
                          ;[lucid.publish publish copy-assets]
                          ;[lucid.package pull list-dependencies resolve-with-dependencies]
                          ;[lucid.core.namespace run clear-aliases clear-mappings]
                          ;[lucid.unit import scaffold purge missing orphaned in-order? arrange]

                          ;clojure.core
                          ;[lucid.mind .& .> .? .* .% .%> .>var .>ns]

                          ;clojure.core
                          ;[lucid.core.debug :refer [[dbg-> *->] [dbg->> *->>]]]

                          ;; clojure.core
                          ;; [clojure.repl dir]
               ;; )
               (require 'clojure.pprint)
               (require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]



  :repl-options {; a colored prompt
                 :prompt (fn [ns] (str "[" ns "](\u001b[36mλ\u001b[0m)> "))
                 }

  :ultra {:color-scheme :solarized_dark
          :stacktraces true ;;false
          :repl {:extend-notation true
                 :print-meta true
                 }}

 }};:user
{:repl
 {:plugins [[cider/cider-nrepl "0.21.1"]
            [refactor-nrepl "2.4.0"]
           ;; ;[venantius/ultra "0.5.2"]
           ;; ;[lein-shell "0.5.0"]
            [com.billpiel/sayid "0.0.17"]
            [io.aviso/pretty "0.1.35"]
            [lein-ancient "0.6.15"]
            ]
                                        ;:prep-tasks ["shell" "ls" "-a"]
  :dependencies [[proto-repl "0.3.1"]
                 [nrepl "0.7.0-SNAPSHOT"];for sayid
                 [io.aviso/pretty "0.1.33"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.namespace "0.2.5"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/tools.trace "0.7.9"]
                 ;; [zcaudate/lucid.mind "1.4.7"]
                 ;; [zcaudate/lucid.publish "1.4.7"]
                 ;; [zcaudate/lucid.unit "1.4.7"]
                 ;; [zcaudate/lucid.package "1.4.7"]
                 ;; [zcaudate/lucid.core.debug "1.4.7"]
                 ; [zcaudate/lucid.core.inject "1.4.7"]
                 ;; [zcaudate/lucid.core.namespace "1.4.7"]
                 ;; [zcaudate/hara.test "2.8.7"]
                 [hara/lib.aether "3.0.5"]
                 [spieden/spyscope "0.1.7"]]
  :repl-options {:nrepl-middleware
                 [cider.nrepl/wrap-apropos
                  cider.nrepl/wrap-classpath
                  cider.nrepl/wrap-complete
                  cider.nrepl/wrap-debug
                  cider.nrepl/wrap-format
                  cider.nrepl/wrap-info
                  cider.nrepl/wrap-inspect
                  cider.nrepl/wrap-macroexpand
                  cider.nrepl/wrap-ns
                  cider.nrepl/wrap-spec
                  cider.nrepl/wrap-pprint
                  cider.nrepl/wrap-pprint-fn
                  cider.nrepl/wrap-refresh
                  cider.nrepl/wrap-resource
                  cider.nrepl/wrap-stacktrace
                  cider.nrepl/wrap-test
                  cider.nrepl/wrap-trace
                  cider.nrepl/wrap-out
                  cider.nrepl/wrap-undef
                  cider.nrepl/wrap-version]}



}}
