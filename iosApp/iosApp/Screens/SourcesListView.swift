import shared
import SwiftUI

struct SourcesListView: View {
    let sources: [Source]
    
    private struct SourceItem: Identifiable {
        let id: Int
        let name: String
        let desc: String
        let language: String
    }
    
    private var items: [SourceItem] {
        sources.enumerated().map { index, source in
            SourceItem(
                id: index,
                name: source.name ?? "Unknown",
                desc: source.description ?? "No description",
                language: source.language ?? "Unknown language"
            )
        }
    }
    
    var body: some View {
        List(items) { item in
            VStack(alignment: .leading, spacing: 4) {
                Text(item.name)
                    .font(.body)
                    .foregroundStyle(.primary)
                Text(item.desc)
                    .font(.footnote)
                    .foregroundStyle(.secondary)
                Text(item.language)
                    .font(.caption)
                    .foregroundStyle(.tertiary)
            }
            .padding(.vertical, 4)
        }
    }
}
