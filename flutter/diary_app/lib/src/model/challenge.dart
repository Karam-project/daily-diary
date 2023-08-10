import 'dart:convert';

import 'package:diary_app/src/model/user.dart';

List<Challenge> challengeFromJson(String str) => List<Challenge>.from(json.decode(utf8.decode(str.runes.toList())).map((x) => Challenge.fromJson(x)));

String challengeToJson(List<Challenge> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Challenge {
  final int id;
  final String name;
  final User user;
  final DateTime createDateTime;
  final DateTime upDateTime;

  Challenge({
    required this.id,
    required this.name,
    required this.user,
    required this.createDateTime,
    required this.upDateTime,
  });

  factory Challenge.fromJson(Map<String, dynamic> json) => Challenge(
    id: json["id"],
    name: json["name"],
    user: User.fromJson(json["user"]),
    createDateTime: DateTime.parse(json["createDateTime"]),
    upDateTime: DateTime.parse(json["upDateTime"]),
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "name": name,
    "user": user.toJson(),
    "createDateTime": "${createDateTime.year.toString().padLeft(4, '0')}-${createDateTime.month.toString().padLeft(2, '0')}-${createDateTime.day.toString().padLeft(2, '0')}",
    "upDateTime": "${upDateTime.year.toString().padLeft(4, '0')}-${upDateTime.month.toString().padLeft(2, '0')}-${upDateTime.day.toString().padLeft(2, '0')}",
  };
}

