import SwiftUI
import shared

struct ContentView: View {
    @State private var shouldOpenAbout = false
    @State private var shouldOpenSources = false
    let articleScreen = ArticlesScreen(viewModel: .init())

    var body: some View {
        NavigationStack {
            articleScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutScreen()
                        }
                    }
                    ToolbarItem(placement: .topBarLeading) {
                        Button {
                            shouldOpenSources = true
                        } label: {
                            Label("Sources", systemImage: "list.bullet")
                                .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenSources) {
                            SourcesScreen(viewModel: articleScreen.viewModel)
                        }
                    }
                }
        }
        .refreshable {
            articleScreen.viewModel.articlesViewModel.forceRefresh()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
