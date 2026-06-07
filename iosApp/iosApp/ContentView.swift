import SwiftUI
import shared

struct ContentView: View {

    @State private var shouldOpenAbout = false
    let articleScreen = ArticlesScreen(viewModel: .init())

    var body: some View {
        NavigationStack{
            articleScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutScreen()
                        }
                    }
                }
        }.refreshable {
           articleScreen.viewModel.articlesViewModel.forceRefresh()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
