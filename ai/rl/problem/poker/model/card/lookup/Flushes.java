package ao.ai.rl.problem.poker.model.card.lookup;

/**
 * Has to be separate to prevent "Code too large" error.
 */
public class Flushes
{
    //--------------------------------------------------------------------
    private Flushes() {}


    //--------------------------------------------------------------------
    public static int at(int index)
    {
        return flushes[ index ];
    }


    //--------------------------------------------------------------------
    /*
    ** this is a table lookup for all "flush" hands (e.g.  both
    ** flushes and straight-flushes.  entries containing a zero
    ** mean that combination is not possible with a five-card
    ** flush hand.
    */
//    private static final int flushesA[] = {
    private static final int flushes[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 1599, 0, 0, 0, 0, 0, 0, 0, 1598, 0, 0, 0, 1597, 0, 1596,
        8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1595, 0, 0, 0,
        0, 0, 0, 0, 1594, 0, 0, 0, 1593, 0, 1592, 1591, 0, 0, 0, 0, 0, 0,
        0,  0,  1590,  0, 0, 0, 1589, 0, 1588, 1587, 0, 0, 0, 0, 1586, 0,
        1585, 1584, 0, 0, 1583, 1582, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 1581, 0, 0, 0, 0, 0, 0, 0, 1580, 0, 0, 0,
        1579, 0, 1578, 1577, 0, 0, 0, 0, 0, 0, 0, 0, 1576, 0, 0, 0, 1575,
        0, 1574, 1573, 0, 0, 0, 0, 1572, 0, 1571, 1570, 0, 0, 1569, 1568,
        0, 1567, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1566, 0, 0,  0,  1565,  0,
        1564, 1563, 0, 0, 0, 0, 1562, 0, 1561, 1560, 0, 0, 1559, 1558, 0,
        1557, 0, 0, 0, 0, 0, 0, 1556, 0, 1555, 1554, 0, 0, 1553, 1552, 0,
        1551, 0, 0, 0, 0, 1550, 1549, 0, 1548, 0, 0, 0, 6, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1547, 0, 0, 0,
        0, 0, 0, 0, 1546, 0, 0, 0, 1545, 0, 1544, 1543, 0, 0, 0, 0, 0, 0,
        0, 0, 1542, 0, 0, 0, 1541, 0, 1540, 1539, 0, 0, 0,  0,  1538,  0,
        1537, 1536, 0, 0, 1535, 1534, 0, 1533, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 1532, 0, 0, 0, 1531, 0, 1530, 1529, 0, 0, 0, 0, 1528, 0, 1527,
        1526, 0, 0, 1525, 1524, 0, 1523, 0, 0, 0, 0, 0, 0, 1522, 0, 1521,
        1520, 0, 0, 1519, 1518, 0, 1517, 0, 0, 0, 0, 1516, 1515, 0, 1514,
        0, 0, 0, 1513, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1512, 0,
        0, 0, 1511, 0, 1510, 1509, 0, 0, 0, 0, 1508, 0, 1507, 1506, 0, 0,
        1505, 1504, 0, 1503, 0, 0, 0, 0, 0, 0, 1502, 0, 1501, 1500, 0, 0,
        1499, 1498, 0, 1497, 0, 0, 0, 0, 1496, 1495, 0, 1494,  0,  0,  0,
        1493,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 1492, 0, 1491, 1490, 0, 0,
        1489, 1488, 0, 1487, 0, 0, 0, 0, 1486, 1485, 0, 1484,  0,  0,  0,
        1483, 0, 0, 0, 0, 0, 0, 0, 0, 1482, 1481, 0, 1480, 0, 0, 0, 1479,
        0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1478, 0, 0, 0, 0,
        0, 0, 0, 1477, 0, 0, 0, 1476, 0, 1475, 1474, 0, 0, 0, 0, 0, 0, 0,
        0, 1473, 0, 0, 0, 1472, 0, 1471, 1470, 0, 0, 0, 0, 1469, 0, 1468,
        1467, 0, 0, 1466, 1465, 0, 1464, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,
        1463,  0,  0,  0, 1462, 0, 1461, 1460, 0, 0, 0, 0, 1459, 0, 1458,
        1457, 0, 0, 1456, 1455, 0, 1454, 0, 0, 0, 0, 0, 0, 1453, 0, 1452,
        1451, 0, 0, 1450, 1449, 0, 1448, 0, 0, 0, 0, 1447, 1446, 0, 1445,
        0, 0, 0, 1444, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1443, 0,
        0, 0, 1442, 0, 1441, 1440, 0, 0, 0, 0, 1439, 0, 1438, 1437, 0, 0,
        1436, 1435, 0, 1434, 0, 0, 0, 0, 0, 0, 1433, 0, 1432, 1431, 0, 0,
        1430,  1429,  0,  1428, 0, 0, 0, 0, 1427, 1426, 0, 1425, 0, 0, 0,
        1424, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1423, 0, 1422,  1421,  0,  0,
        1420,  1419,  0,  1418, 0, 0, 0, 0, 1417, 1416, 0, 1415, 0, 0, 0,
        1414, 0, 0, 0, 0, 0, 0, 0, 0, 1413, 1412, 0, 1411, 0, 0, 0, 1410,
        0, 0, 0, 0, 0, 0, 0, 1409, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 1408, 0, 0, 0, 1407, 0, 1406, 1405, 0,
        0, 0, 0, 1404, 0, 1403, 1402, 0, 0, 1401, 1400, 0, 1399, 0, 0, 0,
        0, 0, 0, 1398, 0, 1397, 1396, 0, 0, 1395, 1394, 0, 1393, 0, 0, 0,
        0, 1392, 1391, 0, 1390, 0, 0, 0, 1389, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 1388, 0, 1387, 1386, 0, 0, 1385, 1384, 0, 1383, 0,  0,  0,  0,
        1382, 1381, 0, 1380, 0, 0, 0, 1379, 0, 0, 0, 0, 0, 0, 0, 0, 1378,
        1377, 0, 1376, 0, 0, 0, 1375, 0, 0, 0, 0, 0, 0, 0, 1374, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1373, 0, 1372, 1371,
        0, 0, 1370, 1369, 0, 1368, 0, 0, 0, 0, 1367, 1366, 0, 1365, 0, 0,
        0,  1364,  0,  0, 0, 0, 0, 0, 0, 0, 1363, 1362, 0, 1361, 0, 0, 0,
        1360, 0, 0, 0, 0, 0, 0, 0, 1359, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 1358, 1357, 0, 1356, 0, 0, 0, 1355, 0, 0, 0, 0, 0,
        0, 0, 1354, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1353, 0, 0, 0, 0, 0, 0, 0, 1352, 0, 0, 0, 1351, 0, 1350, 1349, 0,
        0, 0, 0, 0, 0, 0, 0, 1348, 0, 0, 0, 1347, 0, 1346, 1345, 0, 0, 0,
        0, 1344, 0, 1343, 1342, 0, 0, 1341, 1340, 0, 1339, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 1338, 0, 0, 0, 1337, 0, 1336, 1335, 0,  0,  0,  0,
        1334, 0, 1333, 1332, 0, 0, 1331, 1330, 0, 1329, 0, 0, 0, 0, 0, 0,
        1328, 0, 1327, 1326, 0, 0, 1325, 1324, 0, 1323, 0, 0, 0, 0, 1322,
        1321, 0, 1320, 0, 0, 0, 1319, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 1318, 0, 0, 0, 1317, 0, 1316, 1315, 0, 0, 0,  0,  1314,  0,
        1313, 1312, 0, 0, 1311, 1310, 0, 1309, 0, 0, 0, 0, 0, 0, 1308, 0,
        1307, 1306, 0, 0, 1305, 1304, 0, 1303, 0, 0, 0, 0, 1302, 1301, 0,
        1300, 0, 0, 0, 1299, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1298, 0, 1297,
        1296, 0, 0, 1295, 1294, 0, 1293, 0, 0, 0, 0, 1292, 1291, 0, 1290,
        0, 0, 0, 1289, 0, 0, 0, 0, 0, 0, 0, 0, 1288, 1287, 0, 1286, 0, 0,
        0, 1285, 0, 0, 0, 0, 0, 0, 0, 1284, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1283, 0, 0, 0, 1282, 0, 1281,
        1280, 0, 0, 0, 0, 1279, 0, 1278, 1277, 0, 0, 1276, 1275, 0, 1274,
        0, 0, 0, 0, 0, 0, 1273, 0, 1272, 1271, 0, 0, 1270, 1269, 0, 1268,
        0, 0, 0, 0, 1267, 1266, 0, 1265, 0, 0, 0, 1264, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 1263, 0, 1262, 1261, 0, 0, 1260, 1259, 0, 1258, 0, 0,
        0, 0, 1257, 1256, 0, 1255, 0, 0, 0, 1254, 0, 0, 0, 0, 0, 0, 0, 0,
        1253, 1252, 0, 1251, 0, 0, 0, 1250, 0, 0, 0, 0, 0, 0, 0, 1249, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1248, 0, 1247,
        1246, 0, 0, 1245, 1244, 0, 1243, 0, 0, 0, 0, 1242, 1241, 0, 1240,
        0, 0, 0, 1239, 0, 0, 0, 0, 0, 0, 0, 0, 1238, 1237, 0, 1236, 0, 0,
        0, 1235, 0, 0, 0, 0, 0, 0, 0, 1234, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1233, 1232, 0, 1231, 0, 0, 0, 1230, 0, 0, 0, 0,
        0, 0, 0, 1229, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1228,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1227, 0, 0, 0,
        1226, 0, 1225, 1224, 0, 0, 0, 0, 1223, 0, 1222, 1221, 0, 0, 1220,
        1219, 0, 1218, 0, 0, 0, 0, 0, 0, 1217, 0, 1216, 1215, 0, 0, 1214,
        1213, 0, 1212, 0, 0, 0, 0, 1211, 1210, 0, 1209, 0, 0, 0, 1208, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 1207, 0, 1206, 1205, 0, 0, 1204, 1203,
        0, 1202, 0, 0, 0, 0, 1201, 1200, 0, 1199, 0, 0, 0, 1198, 0, 0, 0,
        0, 0, 0, 0, 0, 1197, 1196, 0, 1195, 0, 0, 0, 1194, 0, 0, 0, 0, 0,
        0, 0, 1193, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1192, 0, 1191, 1190, 0, 0, 1189, 1188, 0, 1187, 0, 0, 0, 0, 1186,
        1185, 0, 1184, 0, 0, 0, 1183, 0, 0, 0, 0, 0, 0, 0, 0, 1182, 1181,
        0, 1180, 0, 0, 0, 1179, 0, 0, 0, 0, 0, 0, 0, 1178, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1177, 1176, 0, 1175,  0,  0,  0,
        1174, 0, 0, 0, 0, 0, 0, 0, 1173, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 1172, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1171, 0,
        1170, 1169, 0, 0, 1168, 1167, 0, 1166, 0, 0, 0, 0, 1165, 1164, 0,
        1163, 0, 0, 0, 1162, 0, 0, 0, 0, 0, 0, 0, 0, 1161, 1160, 0, 1159,
        0, 0, 0, 1158, 0, 0, 0, 0, 0, 0, 0, 1157, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 1156, 1155, 0, 1154, 0, 0, 0, 1153, 0, 0,
        0, 0, 0, 0, 0, 1152, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1151, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1150, 1149, 0, 1148, 0, 0, 0,
        1147, 0, 0, 0, 0, 0, 0, 0, 1146, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 1145, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1144, 0, 0, 0, 0, 0, 0, 0, 1143, 0, 0, 0, 1142,
        0, 1141, 1140, 0, 0, 0, 0, 0, 0, 0, 0, 1139, 0, 0,  0,  1138,  0,
        1137, 1136, 0, 0, 0, 0, 1135, 0, 1134, 1133, 0, 0, 1132, 1131, 0,
        1130, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1129, 0, 0, 0, 1128, 0, 1127,
        1126, 0, 0, 0, 0, 1125, 0, 1124, 1123, 0, 0, 1122, 1121, 0, 1120,
        0, 0, 0, 0, 0, 0, 1119, 0, 1118, 1117, 0, 0, 1116, 1115, 0, 1114,
        0, 0, 0, 0, 1113, 1112, 0, 1111, 0, 0, 0, 1110, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 1109, 0, 0, 0, 1108, 0, 1107, 1106, 0, 0,
        0, 0, 1105, 0, 1104, 1103, 0, 0, 1102, 1101, 0, 1100, 0, 0, 0, 0,
        0, 0, 1099, 0, 1098, 1097, 0, 0, 1096, 1095, 0, 1094, 0, 0, 0, 0,
        1093, 1092, 0, 1091, 0, 0, 0, 1090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1089, 0, 1088, 1087, 0, 0, 1086, 1085, 0, 1084, 0, 0, 0, 0, 1083,
        1082, 0, 1081, 0, 0, 0, 1080, 0, 0, 0, 0, 0, 0, 0, 0, 1079, 1078,
        0, 1077, 0, 0, 0, 1076, 0, 0, 0, 0, 0, 0, 0, 1075, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1074, 0, 0, 0,
        1073, 0, 1072, 1071, 0, 0, 0, 0, 1070, 0, 1069, 1068, 0, 0, 1067,
        1066, 0, 1065, 0, 0, 0, 0, 0, 0, 1064, 0, 1063, 1062, 0, 0, 1061,
        1060, 0, 1059, 0, 0, 0, 0, 1058, 1057, 0, 1056, 0, 0, 0, 1055, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 1054, 0, 1053, 1052, 0, 0, 1051, 1050,
        0, 1049, 0, 0, 0, 0, 1048, 1047, 0, 1046, 0, 0, 0, 1045, 0, 0, 0,
        0, 0, 0, 0, 0, 1044, 1043, 0, 1042, 0, 0, 0, 1041, 0, 0, 0, 0, 0,
        0, 0, 1040, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1039, 0, 1038, 1037, 0, 0, 1036, 1035, 0, 1034, 0, 0, 0, 0, 1033,
        1032, 0, 1031, 0, 0, 0, 1030, 0, 0, 0, 0, 0, 0, 0, 0, 1029, 1028,
        0, 1027, 0, 0, 0, 1026, 0, 0, 0, 0, 0, 0, 0, 1025, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1024, 1023, 0, 1022,  0,  0,  0,
        1021, 0, 0, 0, 0, 0, 0, 0, 1020, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 1019, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1018, 0, 0, 0, 1017, 0, 1016, 1015, 0, 0, 0, 0,  1014,  0,  1013,
        1012, 0, 0, 1011, 1010, 0, 1009, 0, 0, 0, 0, 0, 0, 1008, 0, 1007,
        1006, 0, 0, 1005, 1004, 0, 1003, 0, 0, 0, 0, 1002, 1001, 0, 1000,
        0,  0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 998, 0, 997, 996, 0,
        0, 995, 994, 0, 993, 0, 0, 0, 0, 992, 991, 0, 990, 0, 0, 0,  989,
        0,  0, 0, 0, 0, 0, 0, 0, 988, 987, 0, 986, 0, 0, 0, 985, 0, 0, 0,
        0, 0, 0, 0, 984, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0, 983, 0, 982, 981, 0, 0, 980, 979, 0, 978, 0, 0, 0, 0, 977,
        976, 0, 975, 0, 0, 0, 974, 0, 0, 0, 0, 0, 0, 0, 0, 973,  972,  0,
        971, 0, 0, 0, 970, 0, 0, 0, 0, 0, 0, 0, 969, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 968, 967, 0, 966, 0, 0, 0, 965, 0,  0,
        0,  0, 0, 0, 0, 964, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        963, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 962, 0, 961, 960, 0, 0,
        959, 958, 0, 957, 0, 0, 0, 0, 956, 955, 0, 954, 0, 0, 0, 953,  0,
        0,  0, 0, 0, 0, 0, 0, 952, 951, 0, 950, 0, 0, 0, 949, 0, 0, 0, 0,
        0, 0, 0, 948, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,
        947,  946,  0, 945, 0, 0, 0, 944, 0, 0, 0, 0, 0, 0, 0, 943, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 942, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 941, 940, 0, 939, 0, 0, 0, 938, 0, 0, 0,  0,  0,  0,  0,
        937,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 936, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 935, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 934, 0, 0, 0,  933,  0,  932,
        931,  0, 0, 0, 0, 930, 0, 929, 928, 0, 0, 927, 926, 0, 925, 0, 0,
        0, 0, 0, 0, 924, 0, 923, 922, 0, 0, 921, 920, 0, 919, 0, 0, 0, 0,
        918,  917,  0,  916,  0, 0, 0, 915, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        914, 0, 913, 912, 0, 0, 911, 910, 0, 909, 0, 0, 0, 0,  908,  907,
        0,  906,  0, 0, 0, 905, 0, 0, 0, 0, 0, 0, 0, 0, 904, 903, 0, 902,
        0, 0, 0, 901, 0, 0, 0, 0, 0, 0, 0, 900, 0, 0, 0, 0, 0, 0,  0,  0,
        0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 899, 0, 898, 897, 0, 0, 896, 895,
        0, 894, 0, 0, 0, 0, 893, 892, 0, 891, 0, 0, 0, 890, 0, 0,  0,  0,
        0,  0, 0, 0, 889, 888, 0, 887, 0, 0, 0, 886, 0, 0, 0, 0, 0, 0, 0,
        885, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 884, 883, 0,
        882, 0, 0, 0, 881, 0, 0, 0, 0, 0, 0, 0, 880, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 879, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        878, 0, 877, 876, 0, 0, 875, 874, 0, 873, 0, 0, 0, 0,  872,  871,
        0,  870,  0, 0, 0, 869, 0, 0, 0, 0, 0, 0, 0, 0, 868, 867, 0, 866,
        0, 0, 0, 865, 0, 0, 0, 0, 0, 0, 0, 864, 0, 0, 0, 0, 0, 0,  0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 863, 862, 0, 861, 0, 0, 0, 860, 0, 0, 0,
        0, 0, 0, 0, 859, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,
        858,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 857, 856, 0, 855,  0,  0,  0,
        854,  0,  0, 0, 0, 0, 0, 0, 853, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 852, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 851, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 850,  0,  849,
        848,  0, 0, 847, 846, 0, 845, 0, 0, 0, 0, 844, 843, 0, 842, 0, 0,
        0, 841, 0, 0, 0, 0, 0, 0, 0, 0, 840, 839, 0, 838, 0, 0,  0,  837,
        0,  0, 0, 0, 0, 0, 0, 836, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 835, 834, 0, 833, 0, 0, 0, 832, 0, 0, 0,  0,  0,  0,  0,
        831,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 830, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 829, 828, 0, 827, 0, 0, 0, 826, 0, 0, 0, 0,
        0, 0, 0, 825, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  824,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 823, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
//    };
//    private static final int flushesB[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 822, 821, 0, 820, 0, 0, 0, 819, 0, 0,
        0, 0, 0, 0, 0, 818, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        817,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 816, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        10, 0, 0, 0, 0, 0, 0, 0, 815, 0, 0, 0, 814, 0, 813, 812, 0, 0, 0,
        0,  0,  0, 0, 0, 811, 0, 0, 0, 810, 0, 809, 808, 0, 0, 0, 0, 807,
        0, 806, 805, 0, 0, 804, 803, 0, 802, 0, 0, 0, 0, 0, 0, 0,  0,  0,
        0,  801, 0, 0, 0, 800, 0, 799, 798, 0, 0, 0, 0, 797, 0, 796, 795,
        0, 0, 794, 793, 0, 792, 0, 0, 0, 0, 0, 0, 791, 0, 790, 789, 0, 0,
        788,  787, 0, 786, 0, 0, 0, 0, 785, 784, 0, 783, 0, 0, 0, 782, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 781, 0, 0, 0, 780, 0, 779,
        778,  0, 0, 0, 0, 777, 0, 776, 775, 0, 0, 774, 773, 0, 772, 0, 0,
        0, 0, 0, 0, 771, 0, 770, 769, 0, 0, 768, 767, 0, 766, 0, 0, 0, 0,
        765,  764,  0,  763,  0, 0, 0, 762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        761, 0, 760, 759, 0, 0, 758, 757, 0, 756, 0, 0, 0, 0,  755,  754,
        0,  753,  0, 0, 0, 752, 0, 0, 0, 0, 0, 0, 0, 0, 751, 750, 0, 749,
        0, 0, 0, 748, 0, 0, 0, 0, 0, 0, 0, 747, 0, 0, 0, 0, 0, 0,  0,  0,
        0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 746, 0, 0, 0, 745, 0,
        744, 743, 0, 0, 0, 0, 742, 0, 741, 740, 0, 0, 739, 738,  0,  737,
        0, 0, 0, 0, 0, 0, 736, 0, 735, 734, 0, 0, 733, 732, 0, 731, 0, 0,
        0, 0, 730, 729, 0, 728, 0, 0, 0, 727, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  726,  0,  725,  724, 0, 0, 723, 722, 0, 721, 0, 0, 0, 0, 720,
        719, 0, 718, 0, 0, 0, 717, 0, 0, 0, 0, 0, 0, 0, 0, 716,  715,  0,
        714, 0, 0, 0, 713, 0, 0, 0, 0, 0, 0, 0, 712, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 711, 0, 710,  709,  0,  0,  708,
        707, 0, 706, 0, 0, 0, 0, 705, 704, 0, 703, 0, 0, 0, 702, 0, 0, 0,
        0, 0, 0, 0, 0, 701, 700, 0, 699, 0, 0, 0, 698, 0, 0, 0, 0, 0,  0,
        0, 697, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 696, 695,
        0, 694, 0, 0, 0, 693, 0, 0, 0, 0, 0, 0, 0, 692, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 691, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0, 0, 0, 690, 0, 0, 0, 689, 0, 688, 687, 0, 0, 0, 0, 686,
        0, 685, 684, 0, 0, 683, 682, 0, 681, 0, 0, 0, 0, 0,  0,  680,  0,
        679,  678,  0, 0, 677, 676, 0, 675, 0, 0, 0, 0, 674, 673, 0, 672,
        0, 0, 0, 671, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 670, 0, 669, 668,  0,
        0,  667, 666, 0, 665, 0, 0, 0, 0, 664, 663, 0, 662, 0, 0, 0, 661,
        0, 0, 0, 0, 0, 0, 0, 0, 660, 659, 0, 658, 0, 0, 0, 657, 0, 0,  0,
        0,  0, 0, 0, 656, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 655, 0, 654, 653, 0, 0, 652, 651, 0, 650, 0, 0, 0, 0,  649,
        648,  0,  647, 0, 0, 0, 646, 0, 0, 0, 0, 0, 0, 0, 0, 645, 644, 0,
        643, 0, 0, 0, 642, 0, 0, 0, 0, 0, 0, 0, 641, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 640, 639, 0, 638, 0, 0, 0, 637, 0, 0,
        0, 0, 0, 0, 0, 636, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        635,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 634, 0, 633, 632, 0, 0,
        631,  630, 0, 629, 0, 0, 0, 0, 628, 627, 0, 626, 0, 0, 0, 625, 0,
        0, 0, 0, 0, 0, 0, 0, 624, 623, 0, 622, 0, 0, 0, 621, 0, 0, 0,  0,
        0,  0,  0,  620,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        619, 618, 0, 617, 0, 0, 0, 616, 0, 0, 0, 0, 0, 0, 0, 615,  0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 614, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  613,  612, 0, 611, 0, 0, 0, 610, 0, 0, 0, 0, 0, 0, 0,
        609, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 608, 0,  0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 607, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 606, 0, 0, 0, 605, 0, 604,
        603, 0, 0, 0, 0, 602, 0, 601, 600, 0, 0, 599, 598, 0, 597, 0,  0,
        0, 0, 0, 0, 596, 0, 595, 594, 0, 0, 593, 592, 0, 591, 0, 0, 0, 0,
        590, 589, 0, 588, 0, 0, 0, 587, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,
        586,  0,  585, 584, 0, 0, 583, 582, 0, 581, 0, 0, 0, 0, 580, 579,
        0, 578, 0, 0, 0, 577, 0, 0, 0, 0, 0, 0, 0, 0, 576, 575,  0,  574,
        0,  0,  0, 573, 0, 0, 0, 0, 0, 0, 0, 572, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 571, 0, 570, 569, 0, 0,  568,  567,
        0,  566,  0, 0, 0, 0, 565, 564, 0, 563, 0, 0, 0, 562, 0, 0, 0, 0,
        0, 0, 0, 0, 561, 560, 0, 559, 0, 0, 0, 558, 0, 0, 0, 0, 0, 0,  0,
        557, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 556, 555, 0,
        554, 0, 0, 0, 553, 0, 0, 0, 0, 0, 0, 0, 552, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 551, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        550,  0,  549, 548, 0, 0, 547, 546, 0, 545, 0, 0, 0, 0, 544, 543,
        0, 542, 0, 0, 0, 541, 0, 0, 0, 0, 0, 0, 0, 0, 540, 539,  0,  538,
        0,  0,  0, 537, 0, 0, 0, 0, 0, 0, 0, 536, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 535, 534, 0, 533, 0, 0, 0, 532, 0, 0,  0,
        0,  0,  0,  0,  531, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        530, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 529, 528, 0, 527, 0, 0, 0,
        526, 0, 0, 0, 0, 0, 0, 0, 525, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,
        0,  0, 0, 0, 524, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 523, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 522, 0, 521,
        520, 0, 0, 519, 518, 0, 517, 0, 0, 0, 0, 516, 515, 0, 514, 0,  0,
        0,  513,  0, 0, 0, 0, 0, 0, 0, 0, 512, 511, 0, 510, 0, 0, 0, 509,
        0, 0, 0, 0, 0, 0, 0, 508, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0,  0,  507,  506, 0, 505, 0, 0, 0, 504, 0, 0, 0, 0, 0, 0, 0,
        503, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 502, 0,  0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 501, 500, 0, 499, 0, 0, 0, 498, 0, 0, 0,  0,
        0,  0,  0, 497, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 496,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 495, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 494, 493, 0, 492, 0, 0, 0, 491, 0,  0,
        0,  0, 0, 0, 0, 490, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        489, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 488, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 487, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 486, 0, 0, 0,  485,  0,
        484,  483,  0, 0, 0, 0, 482, 0, 481, 480, 0, 0, 479, 478, 0, 477,
        0, 0, 0, 0, 0, 0, 476, 0, 475, 474, 0, 0, 473, 472, 0, 471, 0, 0,
        0,  0, 470, 469, 0, 468, 0, 0, 0, 467, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 466, 0, 465, 464, 0, 0, 463, 462, 0, 461, 0,  0,  0,  0,  460,
        459,  0,  458, 0, 0, 0, 457, 0, 0, 0, 0, 0, 0, 0, 0, 456, 455, 0,
        454, 0, 0, 0, 453, 0, 0, 0, 0, 0, 0, 0, 452, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 451, 0, 450, 449, 0, 0, 448,
        447, 0, 446, 0, 0, 0, 0, 445, 444, 0, 443, 0, 0, 0, 442, 0, 0, 0,
        0,  0, 0, 0, 0, 441, 440, 0, 439, 0, 0, 0, 438, 0, 0, 0, 0, 0, 0,
        0, 437, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 436, 435,
        0, 434, 0, 0, 0, 433, 0, 0, 0, 0, 0, 0, 0, 432, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 431, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 430, 0, 429, 428, 0, 0, 427, 426, 0, 425, 0,  0,  0,  0,  424,
        423,  0,  422, 0, 0, 0, 421, 0, 0, 0, 0, 0, 0, 0, 0, 420, 419, 0,
        418, 0, 0, 0, 417, 0, 0, 0, 0, 0, 0, 0, 416, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 415, 414, 0, 413, 0, 0, 0, 412, 0, 0,
        0, 0, 0, 0, 0, 411, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        410,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 409, 408, 0, 407,  0,  0,  0,
        406,  0,  0, 0, 0, 0, 0, 0, 405, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 404, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 403, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 402,  0,  401,
        400,  0, 0, 399, 398, 0, 397, 0, 0, 0, 0, 396, 395, 0, 394, 0, 0,
        0, 393, 0, 0, 0, 0, 0, 0, 0, 0, 392, 391, 0, 390, 0, 0,  0,  389,
        0,  0, 0, 0, 0, 0, 0, 388, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 387, 386, 0, 385, 0, 0, 0, 384, 0, 0, 0,  0,  0,  0,  0,
        383,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 382, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 381, 380, 0, 379, 0, 0, 0, 378, 0, 0, 0, 0,
        0, 0, 0, 377, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  376,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 375, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 374, 373, 0, 372, 0, 0, 0, 371, 0, 0,
        0, 0, 0, 0, 0, 370, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        369,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 368, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 367, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 366, 0, 365, 364, 0, 0, 363, 362,
        0, 361, 0, 0, 0, 0, 360, 359, 0, 358, 0, 0, 0, 357, 0, 0,  0,  0,
        0,  0, 0, 0, 356, 355, 0, 354, 0, 0, 0, 353, 0, 0, 0, 0, 0, 0, 0,
        352, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 351, 350, 0,
        349, 0, 0, 0, 348, 0, 0, 0, 0, 0, 0, 0, 347, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 346, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 345,
        344, 0, 343, 0, 0, 0, 342, 0, 0, 0, 0, 0, 0, 0, 341, 0, 0, 0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 340, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        339,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        338, 337, 0, 336, 0, 0, 0, 335, 0, 0, 0, 0, 0, 0, 0, 334,  0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 333, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 332, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 331, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        330, 329, 0, 328, 0, 0, 0, 327, 0, 0, 0, 0, 0, 0, 0, 326,  0,  0,
        0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 325, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0,  0, 324, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 323, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1
    };
//    private static final int flushes[];
//    static
//    {
//        flushes = new int[flushesA.length + flushesB.length];
//        System.arraycopy(flushesA, 0, flushes, 0, flushesA.length);
//        for (int i = 0; i < flushesB.length; i++)
//        {
//            flushes[ flushesA.length + i ] = flushesB[ i ];
//        }
//    }
}
