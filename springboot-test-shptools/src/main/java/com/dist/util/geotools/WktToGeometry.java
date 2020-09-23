package com.zja.util.geotools;

import com.alibaba.fastjson.JSON;
import com.zja.dto.PolygonObject;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.WKTReader;
import org.geotools.geojson.geom.GeometryJSON;

import java.io.StringWriter;
import java.util.List;

/**
 * @author zhengja@dist.com.cn
 * @data 2019/8/29 9:25
 */
public class WktToGeometry {

    private static GeometryFactory geometryFactory = new GeometryFactory();

    public static void main(String[] args) {

        //项目数据
        String wktjson = "{\"rings\":[[[120.01481126800002,30.686383128000074],[120.0148690840001,30.686365174000098],[120.01505557100008,30.686386795000022],[120.01534595500003,30.686396879000057],[120.01533167000001,30.686650692000097],[120.01565841500003,30.686592511000079],[120.01581216000015,30.686459598000095],[120.01579599200014,30.686333997000094],[120.01590043000007,30.686279364000015],[120.01597513900005,30.68623994400004],[120.01605798600006,30.686164802000039],[120.01612006500014,30.686082449000065],[120.01615709799999,30.685964206000051],[120.01619881600007,30.685867604000052],[120.01626902600002,30.685713640000102],[120.01633536600001,30.685538208000064],[120.01637259399998,30.685373515000027],[120.01638904800009,30.685158677000103],[120.01641810800001,30.684851113000057],[120.01642214500008,30.684646835000031],[120.01640564100005,30.684568011000081],[120.01637652100013,30.684521564000057],[120.01632684,30.684471423999994],[120.01628550900014,30.68445348300002],[120.01616539300007,30.684432033000022],[120.01585044900003,30.68440338900005],[120.01565439900006,30.684391274000024],[120.015467918,30.684384082000051],[120.01531462100002,30.684373367000052],[120.01519043200004,30.684341182000054],[120.01506197099998,30.684330465000055],[120.01496262400011,30.684330476000056],[120.01483416400005,30.684334186000097],[120.01470590700001,30.684330505000059],[120.01458558800009,30.684301839000085],[120.01448379700001,30.684301851000086],[120.01442414800015,30.684301857999998],[120.01431238500004,30.684316297000038],[120.01417151100011,30.684348512000039],[120.01400580100008,30.684366477000015],[120.01375315500005,30.684352076000067],[120.01363303700006,30.684319890000069],[120.01356666500007,30.684280484000094],[120.0135336770001,30.684223303000071],[120.0135336660001,30.684140959000008],[120.013562544,30.683926119999995],[120.01361219200011,30.683750692000046],[120.01364482500006,30.683640464000074],[120.0135336500001,30.683612460000067],[120.01352890900014,30.683611293000059],[120.0130657400001,30.683497335000045],[120.01291850800008,30.683631426000037],[120.01283484800001,30.683710024000057],[120.01269762700011,30.683841305999994],[120.01267759200005,30.68386117600004],[120.01266764400012,30.683870026000061],[120.01263019200003,30.683907354000041],[120.01262583600013,30.683912205000087],[120.01256361500012,30.683973378000086],[120.01247047100006,30.684072836000055],[120.01242721200003,30.684119026000058],[120.01237113800001,30.684178901000038],[120.01236387100003,30.684187234000017],[120.01231385100006,30.684245450000038],[120.01220088800004,30.684387271000048],[120.01209549500003,30.684533247000047],[120.01199750300009,30.684682943999999],[120.011985641,30.684702610000027],[120.01197263499999,30.684724171000035],[120.01193908600014,30.684782704000082],[120.01190765100012,30.684836420000085],[120.0118397750001,30.684960974999999],[120.0118086790001,30.685024842000043],[120.01180833900007,30.685026549000007],[120.01200530200002,30.685068190000077],[120.01209651000011,30.685100556000091],[120.01214618900005,30.685139789000051],[120.01214619700013,30.685200667000025],[120.01211709200004,30.685265068000025],[120.01207984100006,30.685293751000088],[120.01200940300009,30.685311705000064],[120.01190598200007,30.685311715000065],[120.01173191700005,30.685286569000027],[120.01171567400004,30.685283066000093],[120.01170924100005,30.685294882000093],[120.01165156700007,30.685451392000076],[120.01162679300015,30.685537209000071],[120.01161995800011,30.685560887000076],[120.01158403400008,30.685647691000064],[120.01153725400002,30.685823585000051],[120.01149532900001,30.685997305000036],[120.01148370600004,30.686136573000013],[120.01149734100009,30.686231173000024],[120.01147101500014,30.686503884000029],[120.01146758300003,30.68653944700004],[120.01131855300005,30.686883723000015],[120.01129074399996,30.687062548000068],[120.01125816200012,30.687240742000068],[120.0112268390001,30.687418973000071],[120.0111839530001,30.687559033000113],[120.01116686700001,30.687684713000031],[120.01098274900006,30.688737978000049],[120.01146460500006,30.688663955000052],[120.01181681000006,30.688617298000011],[120.01222255400015,30.688545648000034],[120.01250024300012,30.688488438000007],[120.01270952200002,30.68841047200004],[120.01279828200009,30.688377384000056],[120.01294343100002,30.68830575800008],[120.0132084830001,30.68814473700008],[120.01342792900004,30.687990758000041],[120.01362681300007,30.687836781000001],[120.01377582600006,30.68774016900009],[120.01394153200009,30.687643379000075],[120.014119658,30.68755397700005],[120.01431020000004,30.68744662700005],[120.01439305000005,30.68737852400001],[120.01447997000005,30.687303209000085],[120.01453370900006,30.687253233000035],[120.01458764100008,30.687124255000111],[120.01462080200007,30.686973990000112],[120.01464968600007,30.686809298000075],[120.01468711000005,30.686572992000062],[120.01470358700008,30.686479912999999],[120.01474083399997,30.686419206000039],[120.01481126800002,30.686383128000074]]],\"spatialReference\":{\"wkid\":4490,\"latestWkid\":4490}}";

        PolygonObject polygonObject = JSON.parseObject(wktjson, PolygonObject.class);
        List<List<Double[]>> rings = polygonObject.getRings();
        Coordinate coords[] = null;
        for (List<Double[]> dou : rings) {
            int i = 0;
            coords = new Coordinate[dou.size()];
            for (Double[] dous : dou) {
                coords[i] = new Coordinate(dous[0], dous[1]);
                System.out.println("coords[i]=" + coords[i] + " dous[0]=" + dous[0] + " " + "dous[1]=" + dous[1]);
                i++;
            }
        }
        System.out.println("spatialReference= " + polygonObject.getSpatialReference());
        Geometry geometry = createGeometry(coords,polygonObject.getSpatialReference().get("wkid"));

        System.out.println("geometry.toText()" + geometry.toText());
        String geojson = wktToJson(geometry.toText());
        System.out.println("geojson=" + geojson);

    }


    /**
     * 获取 Geometry 对象
     *
     * @param coords
     * @return
     */
    public static Geometry createGeometry(Coordinate coords[],Integer wktId) {
        Geometry geometry = null;

        if (isClosed(coords)) {
            //如果是闭合的多边形
            geometry = geometryFactory.createPolygon(coords);
        } else {
            if (coords.length == 1) {
                //如果坐标数组就一个元素的话，除了Point，我想不到其他Geometry
                geometry = geometryFactory.createPoint(coords[0]);
            } else {
                //否则的话，不闭合也不是点，那么它只能是线了--- LineString
                geometry = geometryFactory.createLineString(coords);
            }
        }
        //坐标系
        if (wktId != null){
            geometry.setSRID(wktId);
        }
        System.err.println("类型：" + geometry.getGeometryType() + "\n形态：" + geometry +"\nwktId："+geometry.getSRID());
        return geometry;
    }

    /**
     * 获取 Geometry 对象
     *
     * @param coords
     * @return
     */
    public static Geometry createGeometry(Coordinate coords[]) {
        Geometry geometry = null;

        if (isClosed(coords)) {
            //如果是闭合的多边形
            geometry = geometryFactory.createPolygon(coords);
        } else {
            if (coords.length == 1) {
                //如果坐标数组就一个元素的话，除了Point，我想不到其他Geometry
                geometry = geometryFactory.createPoint(coords[0]);
            } else {
                //否则的话，不闭合也不是点，那么它只能是线了--- LineString
                geometry = geometryFactory.createLineString(coords);
            }
        }
        System.err.println("类型：" + geometry.getGeometryType() + "\n形态：" + geometry +"\nwktId："+geometry.getSRID());
        return geometry;
    }


    /**
     * 判斷 -- 是否是闭合的(Polygon)
     *
     * @param coords
     * @return
     */
    private static boolean isClosed(Coordinate coords[]) {
        /**
         * 闭合条件
         * 1.点(坐标)数组不等于空
         * 2.点(坐标)数组至少含4个元素(>=4 or >3 --  最基本的闭合多边形是---> 三角形)
         * 3.点(坐标)数组首尾元素相当(关键条件，所谓的闭合，也就是首尾点是同一个点，绕了一圈又绕回来了才称之为闭合)
         */
        return coords != null && coords.length > 3 && coords[0].equals(coords[coords.length - 1]);
    }


    /**
     * 由wkt格式的geometry.toText()生成geojson
     *
     * @param wkt
     * @return
     */
    public static String wktToJson(String wkt) {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON(20);
            g.write(geometry, writer);
            json = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


}
