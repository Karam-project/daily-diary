
import 'package:diary_app/src/api/challenge_api.dart';
import 'package:diary_app/src/model/api_message.dart';
import 'package:diary_app/src/model/user.dart';
import 'package:diary_app/src/utility/colors.dart';
import 'package:diary_app/src/view/challenge/challenge_list.dart';
import 'package:diary_app/src/view/layout/white_app_bar.dart';
import 'package:flutter/material.dart';

class RegisterChallenge extends StatefulWidget {
  RegisterChallenge({Key? key}) : super(key: key);

  @override
  State<RegisterChallenge> createState() => _RegisterChallengeState();
}

class _RegisterChallengeState extends State<RegisterChallenge> {
  final _formKey = GlobalKey<FormState>();

  late TextEditingController challengeNameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: WhiteMenuAppBar(title: ''),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  '챌린지 만들기 ',
                  style: TextStyle(
                    fontSize: 30
                  ),
                ),
                Image(image: AssetImage("assets/images/emoji/smile.png"), height: 30,width: 30,),
              ],
            ),
            SizedBox(height: 30,),
            Container(
              width: MediaQuery.of(context).size.width * 0.9,
              child: Form(
                  key: _formKey,
                  child: TextFormField(
                    controller: challengeNameController,
                    decoration: const InputDecoration(
                      hintText: '챌린지명을 입력해주세요',
                      errorStyle: TextStyle(
                        color: ColorStyle.emojiColor5
                      ),
                      border: OutlineInputBorder(),
                      focusedBorder: OutlineInputBorder(
                        borderSide: BorderSide(
                          color: Colors.orange,
                        ),
                      ),
                    ),
                    validator: (value) {
                      if (value!.isEmpty) {
                        return '내용을 입력해주세요.';
                      }
                    },
                  ),
                ),
            ),
            SizedBox(height: 30,),
            SizedBox(
              width: 150,
              height: 50,
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  primary: ColorStyle.emojiColor3,
                ),
                onPressed: () async{
                  final formKeyState = _formKey.currentState!;
                  if (formKeyState.validate()) {
                    formKeyState.save();
                  }
                  await ChallengeAPI().requestRegisterChallengeToSpring(challengeNameController.text, 'aaaa-bbbb', 'uuuu-ggggg');
                  // debugPrint("데이터 확인 ${challengeNameController.text} , ${User().getAdid()} , ${User().getUuid()}" );
                  showAPIMessage(context);
                },
                child: const Text('등록하기', style: TextStyle(fontSize: 15),),
              ),
            ),
            SizedBox(height: 100,),
          ],
        )
      )
    );
  }
}

void showAPIMessage(BuildContext context){
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: new Text(APIMessage().getMSG()),
        content: new Text("감사합니다."),
        actions: <Widget>[
          TextButton(
            child: const Text("닫기"),
            onPressed: (){
              Navigator.pop(context);
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(builder: (context) => ChallengeList()),
              );
                  // .then((value) => setState(() {}));
            },
          ),
        ],
      );
    },
  );
}
