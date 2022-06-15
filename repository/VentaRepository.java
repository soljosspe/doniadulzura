package com.josspepf.doniadulzura.repository;

import com.josspepf.doniadulzura.models.Venta;
import com.josspepf.doniadulzura.models.reportes.ReporteMes;
import com.josspepf.doniadulzura.models.reportes.ReporteProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VentaRepository extends CrudRepository<Venta, Integer> {

    // consulta

    @Query(value = "select MONTHNAME(STR_TO_DATE(month(f.fecha), '%m'))as mes, sum(v.p_total) as venta from factura as f, venta as v where v.factura_id = f.id group by month(f.fecha)  order by 2 desc", nativeQuery = true)
    List<ReporteMes> getMesDeVentas();


    @Query(value = "select concat('Marca: ', m.nombre,', linea: ' , p.nombre) as producto, sum(v.p_total) as venta from producto as p, venta as v, marca as m where v.producto_id = p.id and p.marca_id = m.id group by concat('Marca: ', m.nombre,', producto: ' , p.nombre)  order by 2 desc;", nativeQuery = true)
    List<ReporteProducto> getProductoMasVendido();
}
