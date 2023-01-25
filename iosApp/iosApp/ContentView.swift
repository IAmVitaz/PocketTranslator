import SwiftUI
import shared

struct ContentView: View {

    let appModule: AppModule

    var body: some View {
        ZStack {
             Color.background
                 .ignoresSafeArea()
             TranslateScreen(
                 historyDataSource: appModule.historyDataSource,
                 translateUseCase: appModule.translateUseCase,
                 parser: appModule.voiceParser
             )
         }
        .navigationBarTitleDisplayMode(.inline)
        .navigationBarBackButtonHidden(true) // hides the "back" or previous view title button
    }
}
