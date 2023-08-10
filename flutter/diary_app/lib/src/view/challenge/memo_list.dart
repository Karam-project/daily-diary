import 'package:diary_app/src/view/challenge/component/memo_card.dart';
import 'package:diary_app/src/view/emojiView.dart';
import 'package:diary_app/src/view/layout/white_app_bar.dart';
import 'package:flutter/material.dart';

class MemoList extends StatefulWidget {
  const MemoList({Key? key,
    required this.challengeId,
    required this.challengeName,
    required this.startDate,
  }) : super(key: key);

  final int challengeId;
  final String challengeName;
  final DateTime startDate;

  @override
  State<MemoList> createState() => _MemoListState();
}

class _MemoListState extends State<MemoList> {

  var memoList = false;

  @override
  void initState() {
    super.initState();
    setMemoList();
  }

  void setMemoList() async {
    // await MemoController().requestAllFoundryToSpring();
    setState(() {
      memoList = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: WhiteMenuAppBar(title: ''),
      body: Column(
        children: [
          MemoListTitle(),
          SizedBox(height: 40,),
          MemoList()
        ],
      )
      );
  }

  Widget MemoListTitle(){
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 30, vertical: 20),
      child: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Column(
                  children: [
                    Text('${widget.challengeName}', style:
                    TextStyle(
                        fontSize: 20
                    )),
                    SizedBox(height: 10,),
                    Text('  ${widget.startDate} ~ '),
                  ],
                ),
              ],
            ),
          ]
      ),
    );
  }

  Widget MemoList(){
    return Expanded(
      child:
        SizedBox(
          height: MediaQuery.of(context).size.width * 0.7,
          width: MediaQuery.of(context).size.width * 0.9,
          child:
            GridView.count(
              crossAxisCount: 5,
              children: List.generate(
                    30,
                    (index) => Padding(
                  padding: EdgeInsets.zero,
                  //메모 레코드 카드에 1~30 까지 숫자 붙인 형태로 하고
                  // 삼항 연산자 이용 -> 내용 널이면 빈 표시 만들고 db 내용 있으면 받아오는 걸로하자!
                  child:
                  MemoCard(
                    memoId: 1,
                    num: index + 1,
                    // memoId: MemoInfo.memoList[index]['id']
                    onTap: () {
                      selectMemoCard(index);
                    },
                    //클릭 시
                  ),
                ),
              ),
            ),
        ),
    );
  }

  selectMemoCard(index) async {
    setState(() {
      // MemoInfo.selectedMemo = MemoInfo.memoList[index];
    });
    Navigator.push(context, MaterialPageRoute(builder: (context)
    // => const MemoDetailPage() ));
    => const EmojiView() ));
  }

}

