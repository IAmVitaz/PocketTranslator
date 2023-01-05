import SwiftUI
import shared

struct ContentView: View {
    
    private let appModule = AppModule()
    
    var body: some View {
        ZStack {
             Color.background
                 .ignoresSafeArea()
             TranslateScreen(
                 historyDataSource: appModule.historyDataSource,
                 translateUseCase: appModule.translateUseCase
             )
         }
        .navigationBarTitleDisplayMode(.inline)
        .navigationBarBackButtonHidden(true) // hides the "back" or previous view title button
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
