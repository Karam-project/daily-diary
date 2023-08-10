import 'dart:async';

import 'package:diary_app/src/utility/colors.dart';
import 'package:diary_app/src/view/home_page.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SplashScreenPage extends StatefulWidget{
  const SplashScreenPage({Key? key}) : super(key :key);

  @override
  _SplashScreenPageState createState() => _SplashScreenPageState();
}

class _SplashScreenPageState extends State<SplashScreenPage>{
  @override
  void initState(){
    super.initState();
    Timer( const Duration(seconds: 2), (){
      moveToMain();
    });
  }
  void moveToMain() async {
    Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => HomePage() ));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
          color: ColorStyle.mainColor,
          child: const Center(child: Image(image: AssetImage("assets/images/splash/splash_jump.gif"),))
      ),
    );
  }
}