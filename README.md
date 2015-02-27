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

Make a clone of [Ambly](https://github.com/omcljs/ambly) master. In the Ambly project, go into `ambly/Clojure` and do a `lein install`.

To set up the Shrimp Xcode project, go into `shrimp/iOS` and do `pod install`.

To run Shrimp, first go into the `ClojureScript` directory and run `lein cljsbuild once dev`. This will produce the `main.js` file and `out` directory referenced in the iOS project workspace.

Then open `iOS/Shrimp.xcworkspace` in Xcode and run the project in an iPhone simulator. You should see the main UI come up with a list view showing a list of shrimp names. Tap on any of these to see editable details.

REPL
====

To interact with the app via the Ambly REPL:

1. Run `script/jscrepljs` in the `ClojureScript` directory
2. Choose `[1] Shrimp on iPhone Simulator (<computer name>)`.
3. Make sure that the master view is being shown in the app. (The view listing various shrimp names).
4. In the REPL, do `(require 'shrimp.detail-view-controller)`
5. Then `(in-ns 'shrimp.detail-view-controller)`.
6. In the app, tap on one of the shrimp names to go to a detail view.
6. Try updating the text in one of the fields with `(set! (.-text @name-text-field) "Hello")`.

You can also establish a REPL with a test device; simply follow the same steps but run the app on a device and choose the device when starting the REPL.

Here is what this all looks like in [Cursive](https://cursiveclojure.com) (using a previous copy that worked with Weasel):

![](https://raw.githubusercontent.com/mfikes/shrimp/master/devenv.png)

License
=======

Distributed under the Eclipse Public License, which is also used by ClojureScript.
