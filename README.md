Shrimp
======

Example project using [Goby](https://github.com/mfikes/goby).

Overview
========

This is a sample project illustrating the use of Goby, which is some glue code facilitating the creation of iOS apps in ClojureScript.

This repo is really two projects in one:

1. An iOS app which contains the Storyboards and which loads the compiled JavaScript.
2. A ClojureScript Leiningen project which contains implementations for the view controllers.

This project illustrates how UIKit elements are injected into ClojureScript and how Objective-C protocols such as `UITableViewDataSource` are implemented. It also shows how CoreData can be used, injecting (mutable) CoreData objects into ClojureScript.

Running
=======

The Shrimp project depends on Goby via [CocoaPods](http://cocoapods.org) and [Clojars](https://clojars.org). You do not need to have CocoaPods set up on your Mac; the needed Goby iOS code has been committed to this repo. 

To run Shrimp, first go into the `shrimp/ClojureScript` directory and run `lein cljsbuild once dev`. This will produce the `main.js` file referenced in the iOS project workspace.

Then open `shrimp/iOS/Shrimp.xcworkspace` in Xcode and and run the project in an iPhone simulator. You should see the main UI come up with a list view showing a list of shrimp names. Tap on any of these to see editable details.

REPL
====

To interact with the app via the REPL:

1. Run `lein repl` in the `shrimp/ClojureScript` directory
2. Run `(simple-brepl)` and wait for indicate that it has started the Weasel server.
3. Restart the iOS app in the simulator.
4. Go to the details page for any of the Shrimp
5. In the REPL, switch to the namespace for that view controller using `(in-ns 'shrimp.detail-view-controller)`.
6. Try updating the text in one of the fields with `(set! (.-text @name-text-field) "Hello")`.

You can also establish a REPL over TCP/IP with a test device. To do this, modify `:brepl {:ip "127.0.0.1”}` in `project.clj` and `(ws-repl/connect "ws://127.0.0.1:9001”)` in the `dev` version of `shrimp.init.weasel-connect` to reflect your Mac’s IP address.

Here is what this all looks like in [Cursive](https://cursiveclojure.com):

![](https://raw.githubusercontent.com/mfikes/shrimp/master/devenv.png)

License
=======

Distributed under the Eclipse Public License, which is also used by ClojureScript.
