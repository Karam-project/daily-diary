import 'package:flutter/material.dart';

class MemoCard extends StatelessWidget{
  const MemoCard({Key? key,
    required this.memoId,
    required this.num,
    required this.onTap,
  }) : super(key: key);

  final int memoId, num;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: SingleChildScrollView(
        scrollDirection: Axis.vertical,
        child: Column(
            children: [
              Text('${num}', style:
              TextStyle(
                  fontSize: 13
              )),
              SizedBox(height: 8,),
              Container(
                child: memoId == null?
                Image(image: AssetImage("assets/images/memo/memoji3.png"), height: MediaQuery.of(context).size.width * 0.12, width: MediaQuery.of(context).size.width * 0.12,) :
                Image(image: AssetImage("assets/images/emoji/great1.png"), height: MediaQuery.of(context).size.width * 0.12, width: MediaQuery.of(context).size.width * 0.12,)
              ),
            ],
          ),
      ),
      // onTap:,
      //클릭 이벤트
    );
  }
}