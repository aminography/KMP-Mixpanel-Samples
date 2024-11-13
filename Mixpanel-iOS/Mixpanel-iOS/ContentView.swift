import SwiftUI
import umbrellaKlib

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
        
        private let mixpanel = MixpanelQualifiersKt.MIXPANEL_DELEGATE.resolve() as! MixpanelDelegate
    
        @Published var counter = 1
        
        func onTrackClicked(){
            mixpanel.track(event: "iOS Test Event #\(counter)")
            counter = counter + 1
        }
    }
}
