declare module '*.jpg';
declare module '*.png';
declare module '*.webp';
declare module '*.jpeg';
declare module '*.gif';
declare module '*.mp4';
declare module '*.json';
declare module '*.js';

declare module 'react-native-refreshable-listview';

type JobEntity = {
    id: string;
    memberInfo: string;
    memberId: string;
    companyId: string;
    jobName: string;
    salaryRangeStart: number;
    salaryRangeEnd: number;
    salaryOptional: {
        payDay: string;
        subsidy: string[];
        basicSalary: number;
        socialSecurity: string;
    };
    workYearRangeStart: number;
    workYearRangeEnd: number;
    ageRangeStart: number;
    ageRangeEnd: number;
    educationAttainment: string;
    jobTags: string;
    jobDescription: string;
    replyCount: number;
    longitude: number;
    latitude: number;
    country: string;
    province: string;
    city: string;
    district: string;
    addressDetail: string;
    createdAt: string;
    updatedAt: string;

    companyResponse: {
        id: string;
        applyMemberId: string;
        companyFullName: string;
        companyAbbrName: string;
        companyLogo: string;
        companyDescription: string;
        companyScale: string;
        financingStage: string;
        industry: string;
        workDateStart: string;
        workDateEnd: string;
        restWay: number;
        overtime: number;
        photo: string;
        employeeWelfare: string;
        mainBusiness: string;
        longitude: number;
        latitude: number;
        country: string;
        province: string;
        city: string;
        district: string;
        addressDetail: string;
    }
}