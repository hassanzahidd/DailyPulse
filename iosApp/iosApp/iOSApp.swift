import SwiftUI
import shared
@main
struct iOSApp: App {
    init() {
		KoinInitKt.koinInit()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
