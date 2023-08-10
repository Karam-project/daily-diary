
import 'package:diary_app/src/provider/challenge_provider.dart';
import 'package:diary_app/src/utility/colors.dart';
import 'package:diary_app/src/view/challenge/component/challenge_card.dart';
import 'package:diary_app/src/view/challenge/memo_list.dart';
import 'package:diary_app/src/view/challenge/register_challenge.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class ChallengeList extends StatefulWidget {
  const ChallengeList({Key? key}) : super(key: key);

  _ChallengeList createState() => _ChallengeList();
}

class _ChallengeList extends State<ChallengeList> {

  bool isLoadingChallenge = false;

  @override
  void initState() {
    super.initState();
    checkChallenge();
  }

  void checkChallenge() async{
    final provider = Provider.of<ChallengeProvider>(context, listen: false);
    await provider.loadChallenges('uuuu-ggggg');

    setState(() {
      isLoadingChallenge = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body:  SingleChildScrollView(
        scrollDirection: Axis.vertical,
        child: Center(
          child: Column(
              children:[
                ChallengeListTitle(),
                SizedBox(height: 20),
                SingleChildScrollView(
                  child: isLoadingChallenge == false? isPresentChallengeList(context): isPresentChallengeList(context),
                  // child: isLoadingChallenge == false? isNullChallengeList(): isPresentChallengeList(),
                )
                // ChallengeListComponent(),
              ]
          ),
        ),
      ),
          bottomNavigationBar: BottomAppBar(),
    );
  }
}

class ChallengeListTitle extends StatelessWidget {
  const ChallengeListTitle({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
        width: MediaQuery.of(context).size.width * 0.9,
        margin: EdgeInsets.only(top:70, bottom: 12),
        child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Row(
                children: [
                  SizedBox(width: 20,),
                  Text('나의 챌린지 ',
                    style: TextStyle(
                        fontSize: 25
                    ),
                  ),
                  Image(image: AssetImage("assets/images/emoji/hands_emoji1.png"), height: 40,width: 50,),
                ],
              ),
              Padding(
                padding: EdgeInsets.only(right: 15),
                child:
                Container(
                  height: 40,
                  width: 40,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    color: ColorStyle.emojiColor2,
                  ),
                  child: IconButton(onPressed: (){
                    Navigator.push(context, MaterialPageRoute(builder: (context) => RegisterChallenge()));
                  },
                      icon: Icon(Icons.add, color: Colors.white,)
                  ),
                ),
              ),
            ]
        )
    );
  }
}

  Widget isNullChallengeList(){
    return Center(
      child: Container(
        width: double.infinity,
        padding: EdgeInsets.all(50),
        child: Text("등록된 챌린지가 없습니다. 챌린지를 등록해서 꾸준한 습관을 만들어보세요!"),
      ),
    );
  }

  Widget isPresentChallengeList(BuildContext context){

    final provider = Provider.of<ChallengeProvider>(context);

    return SingleChildScrollView(
      scrollDirection: Axis.vertical,
      child: Column(
          children:
          List.generate(
               // 5,
              provider.challenges.length,
                  (index) => Padding(
                padding: EdgeInsets.zero,
                child: ChallengeCard(
                  challengeId: provider.challenges[index].id,
                  challengeName: provider.challenges[index].name,
                  startDate: provider.challenges[index].createDateTime,
                  onTap: () {
                    //메모 작성 페이지로 이동하도록 수정
                    Navigator.push(context, MaterialPageRoute(builder: (context) => MemoList(
                      challengeId: provider.challenges[index].id,
                      challengeName: provider.challenges[index].name,
                      startDate: provider.challenges[index].createDateTime,
                    )));
                  },
                ),
              )
          )

      ),
    );
  }