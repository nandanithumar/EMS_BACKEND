//package com.argus.ems.processdeployment.mapper;
//
//import com.argus.ems.common.dto.info.MetaInfo;
//import com.argus.ems.common.dto.info.RichTextInfo;
//import com.argus.ems.master.dto.info.TypeInfo;
//import com.argus.ems.master.model.TypeEntity;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public final class EmployeeMapper {
//
//    private EmployeeMapper() {
//    }
//
//    /**
//     * Convert Type to TypeInfo.
//     *
//     * @param type type
//     * @return TypeInfo converted from Type
//     */
//    public static TypeInfo convertTypeToTypeInfo(TypeEntity type) {
//        System.out.println("Reached nnu");
//
//        TypeInfo typeInfo = new TypeInfo();
//        MetaInfo meta = new MetaInfo();
//        RichTextInfo description = new RichTextInfo();
//        
//        
//
//        description.setFormatted(type.getDescriptionFormatted());
//        description.setPlain(type.getDescriptionPlain());
//        
//        
//        meta.setCreatedAt(type.getCreatedAt());
//        meta.setCreatedBy(type.getCreatedBy());
//        meta.setUpdatedAt(type.getUpdatedAt());
//        meta.setUpdatedBy(type.getUpdatedBy());
////        meta.setVersion(type.getVersion());
//
//        typeInfo.setId(type.getId());
//        typeInfo.setName(type.getName());
//        typeInfo.setRefObjUri(type.getRefObjectUri());
//        typeInfo.setEffectiveDate(type.getEffectiveDate());
//        typeInfo.setExpirationDate(type.getExpirationDate());
//        typeInfo.setDescription(description);
//        typeInfo.setMeta(meta);
//        typeInfo.setStateId(type.getStateId());
//
//        System.out.println("type info" + typeInfo);
//        return typeInfo;
//    }
//
//    /**
//     * Convert list of Type Object to list of TypeInfo.
//     *
//     * @param typeObjects list of type objects
//     * @return List of TypeInfo converted from List of Type Object
//     */
//    
//    public static List<TypeInfo> convertTypeObjectsToTypeInfos(List<Object[]> typeObjects) {
//        System.out.println("Reached here");
//        List<TypeInfo> i = typeObjects.stream()
//                     .map(o -> convertTypeToTypeInfo((TypeEntity) o[0]))
//                .collect(Collectors.toList());
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+i);
//        return i;
//    }
//
//    /**
//     * Convert list of Types to list of TypeInfo.
//     *
//     * @param types list of type Entity objects
//     * @return List of TypeInfo converted from List of Type Object
//     */
//    public static List<TypeInfo> convertTypesToTypeInfos(List<TypeEntity> types) {
//        return types.stream()
//                .map(s -> convertTypeToTypeInfo(s))
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Convert TypeInfo to Type.
//     *
//     * @param typeInfo typeInfo
//     * @return Type converted from TypeInfo
//     */
//    public static TypeEntity convertTypeInfoToType(TypeInfo typeInfo) {
//
//        TypeEntity type = new TypeEntity();
//
//        type.setId(typeInfo.getId());
//        type.setName(typeInfo.getName());
//        type.setRefObjectUri(typeInfo.getRefObjectUri());
//        type.setStateId(typeInfo.getStateId());
//     
//
//        if (typeInfo.getDescription() != null) {
//            type.setDescriptionFormatted(typeInfo.getDescription().getFormatted());
//            type.setDescriptionPlain(typeInfo.getDescription().getPlain());
//        }
//
//        type.setEffectiveDate(typeInfo.getEffectiveDate());
//        type.setExpirationDate(typeInfo.getExpirationDate());
//
////        type.setVersion(typeInfo.getMeta().getVersion());
//        return type;
//    }
//}
