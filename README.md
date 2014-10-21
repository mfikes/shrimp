Shrimp
======

Example project using [Goby](https://github.com/mfikes/goby).

Overview
========

This is a sample project illustrating the use of Goby, which is some glue code facilitating the creation of iOS apps in ClojureScript.

This repo is really two projects in one:

1. An iOS app which contains the Storyboards and which loads the compiled JavaScript.
2. A ClojureScript Leiningen project which contains implementations for the view controllers.

The Goby project is reused by simply importing it as a Git submodule, along with a few symbolic links to the relevant iOS and ClojureScript artifacts from Goby so that they appear in the right place.

This project illustrates how UIKit elements are injected into ClojureScript and how Objective-C protocols such as `TableViewDataSource` are implemented. It also shows how CoreData can be used, injecting (mutable) CoreData objects into ClojureScript.

Running
=======

First, go into the `ClojureScript` directory and run `lein cljsbuild once dev`. This will produce the `main.js` file referenced in the iOS project workspace.

Then open the `iOS/Shrimp.xcodeproj` in Xcode and and run the project in an iPhone simulator. You should see the main UI come up with a list view showing a list of shrimp names. Tap on any of these to see editable details.

To interact with the app via the REPL:

1. Run `lein repl` in the `ClojureScript` directory
2. Run `(simple-brepl)`.(Shoutout to James Henderson for [simple-brepl](https://github.com/james-henderson/simple-brepl)!)
3. Restart the iOS app in the simulator.
4. Go to the details page for any of the Shrimp
5. Switch to the namespace for that view controller using `(in-ns 'shrimp.detail-view-controller)`.
6. Try updating the text in one of the fields with `(set! (.-text @name-text-field) "Hello”)`.

Here is what this all looks like in [Cursive](https://cursiveclojure.com):

![](https://raw.githubusercontent.com/mfikes/shrimp/master/devenv.png)

License
=======

Distributed under the Eclipse Public License, which is also used by ClojureScript.
