//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Hassan Zahid on 08/06/2026.
//  Copyright © 2026 orgName. All rights reserved.
//
import SwiftUI
import shared

struct SourcesScreen: View {
    @ObservedObject private(set) var viewModel: ArticlesScreen.ArticlesViewModelWrapper

    var body: some View {
        VStack {
            AppBar(title: "Sources")
            if viewModel.articlesState.loading {
                Loader()
            }
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            if !viewModel.articlesState.sources.isEmpty {
                SourcesListView(sources: viewModel.articlesState.sources)
            }
        }
        .onAppear {
            self.viewModel.startObserving()
        }
    }
}
