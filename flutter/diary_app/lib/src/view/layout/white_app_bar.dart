import 'package:flutter/material.dart';

class WhiteMenuAppBar extends StatelessWidget implements PreferredSizeWidget {
  const WhiteMenuAppBar({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  Size get preferredSize => Size.fromHeight(50);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      iconTheme: IconThemeData(
        color: Colors.grey,
      ),
      elevation: 0.3,
      title: Text(title),
      centerTitle: true,
      backgroundColor: Colors.white,
      leading: InkWell(
        onTap: (){
          Navigator.pop(context);
        },
        child: Icon(Icons.arrow_back_ios_new_outlined, color: Colors.black,),
      ),
    );
  }
}