//
//  ContentView.swift
//  Mixpanel-iOS
//
//  Created by Amin on 27/09/2024.
//

import SwiftUI
import mixpanelLib

struct ContentView: View {
    
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        VStack {
            Button(action: {
                viewModel.onTrackClicked()
            }) {
                Text("Log Event #\(viewModel.counter)")
                    .foregroundColor(.white)
                    .font(.system(size: 16))
                    .bold()
            }
            .buttonStyle(.borderedProminent)
        }
        .padding()
    }
}

extension ContentView {
    
    @MainActor
    class ViewModel: ObservableObject {
        
        private let mixpanel = MixpanelDelegateKt.createMixpanelDelegate(apiToken: "a4e433e173bfbbc0e0784fc22539b790")
    
        @Published var counter = 1
        
        func onTrackClicked(){
            mixpanel.track(event: "iOS Test Event #\(counter)")
            counter = counter + 1
        }
    }
}
