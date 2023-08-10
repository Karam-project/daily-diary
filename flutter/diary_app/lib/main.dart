
import 'package:diary_app/src/api/user_api.dart';
import 'package:diary_app/src/provider/challenge_provider.dart';
import 'package:diary_app/src/view/splash/splash_screen_page.dart';
import 'package:flutter/material.dart';
import 'package:intl/date_symbol_data_local.dart';
import 'package:provider/provider.dart';

void main() {
  initializeDateFormatting().then((_) => runApp(MyApp()));
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _adId = 'Unknown';
  String _uuid = 'Unknown';

  @override
  void initState() {
    super.initState();
    // _init();
    UserAPI().requestRegisterUserToSpring('aaaa-bbbb', 'uuuu-ggggg');
  }
  //
  // Future<void> _init() async {
  //   String? adId;
  //   String? uuid;
  //
  //   try {
  //     // uuid = await UniqueIds.uuid;
  //     // User.uuid = await UniqueIds.uuid??_uuid;
  //     // print("유유아이디: ${User.uuid}");
  //     // User.uuid = 'uuuu-ggggg';
  //   } on PlatformException {
  //     uuid = 'Failed to create uuid.v1';
  //   }
  //
  //   try {
  //     // adId = await UniqueIds.adId;
  //     // User.adid = await UniqueIds.adId?? _adId;
  //     // print("에이디아이디: ${User.adid}");
  //     // User.adid = 'aaaa-bbbb';
  //   } on PlatformException {
  //     adId = 'Failed to get adId version.';
  //   }
  //
  //   if (!mounted) return;
  //
  //   setState(() {
  //     _adId = adId ?? "unknown";
  //     _uuid = uuid ?? "unknown";
  //   });
  // }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(create: (context) => ChallengeProvider(),
        child: MaterialApp(
          debugShowCheckedModeBanner: false,
          title: '달다일기',
          theme: ThemeData(
            scaffoldBackgroundColor: Colors.white,
          ),
          initialRoute: "/splash_page",
          routes: {
            "/splash_page" : (context) => const SplashScreenPage(),
          },
        )
    );
  }
}




